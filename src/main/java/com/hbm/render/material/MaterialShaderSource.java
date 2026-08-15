package com.hbm.render.material;

public class MaterialShaderSource {

    private static final String MIX_LIGHT = """
    vec4 minecraft_mix_light(vec3 lightDir0, vec3 lightDir1, vec3 normal, vec4 color) {
        float light0 = max(0.0, dot(lightDir0, normal));
        float light1 = max(0.0, dot(lightDir1, normal));
        float lightAccum = min(1.0, (light0 + light1) * 0.6 + 0.4);
        return vec4(color.rgb * lightAccum, color.a);
    }
    """;

    public static String vertex(Material mat) {
        boolean entityLightning = mat.lightingMode() == Material.ShadeMode.ENTITY;

        return """
            #version 150
            
            %s
            float fog_distance(vec3 pos, int shape) {
                if (shape == 0) {
                    return length(pos);
                } else {
                    float distXZ = length(pos.xz);
                    float distY = abs(pos.y);
                    return max(distXZ, distY);
                }
            }
            
            uniform sampler2D Sampler1;
            uniform sampler2D Sampler2;
           
            uniform mat4 ModelViewMat;
            uniform mat4 ProjMat;
            uniform mat4 PoseMat;
            uniform int FogShape;

            uniform vec4 Color;
            uniform ivec2 UV1;
            uniform ivec2 UV2;
            uniform mat4 TextureMat;
            
            uniform vec3 Light0_Direction;
            uniform vec3 Light1_Direction;

            in vec3 Position;
            in vec2 UV0;
            in vec3 Normal;

            out float vertexDistance;
            out vec4 vertexColor;
            out vec4 lightMapColor;
            out vec4 overlayColor;
            out vec2 texCoord0;

            void main() {
                vec4 worldPos = PoseMat * vec4(Position, 1.0);
                gl_Position = ProjMat * ModelViewMat * worldPos;
                %s

                vertexDistance = fog_distance(worldPos.xyz, FogShape);
                vertexColor = %s;
                texCoord0 = (TextureMat * vec4(UV0, 0.0, 1.0)).xy;

                overlayColor = texelFetch(Sampler1, UV1, 0);
                lightMapColor = texelFetch(Sampler2, UV2 / 16, 0);
            }
            """
                .formatted(
                        entityLightning ? MIX_LIGHT : "",
                        entityLightning ? "vec3 normalPos = normalize(mat3(PoseMat) * Normal);" : "",
                        entityLightning ? "minecraft_mix_light(Light0_Direction, Light1_Direction, normalPos, Color)" : "Color"
                );
    }

    public static String fragment(Material mat) {
        String cutout = mat.cutout() == Material.CutoutMode.OFF ? "" : ("if (color.a < " + mat.cutout().threshold + ") discard;");

        return """
            #version 150
            
            vec4 linear_fog(vec4 inColor, float vertexDistance, float fogStart, float fogEnd, vec4 fogColor) {
                if (vertexDistance <= fogStart) {
                    return inColor;
                }
    
                float fogValue = vertexDistance < fogEnd ? smoothstep(fogStart, fogEnd, vertexDistance) : 1.0;
                return vec4(mix(inColor.rgb, fogColor.rgb, fogValue * fogColor.a), inColor.a);
            }

            uniform sampler2D Sampler0;
            uniform float FogStart;
            uniform float FogEnd;
            uniform vec4 FogColor;

            in float vertexDistance;
            in vec4 overlayColor;
            in vec4 lightMapColor;
            in vec4 vertexColor;
            in vec2 texCoord0;

            out vec4 fragColor;

            void main() {
                vec4 color = texture(Sampler0, texCoord0);
                %s
                color *= vertexColor;
                color.rgb = mix(overlayColor.rgb, color.rgb, overlayColor.a);
                color *= lightMapColor;
                fragColor = linear_fog(color, vertexDistance, FogStart, FogEnd, FogColor);
            }
            """
                .formatted(cutout);
    }

    public static String json() {
        return """
            {
              "vertex": "hbmsntm:generated",
              "fragment": "hbmsntm:generated",
              "samplers": [
                { "name": "Sampler0" },
                { "name": "Sampler1" },
                { "name": "Sampler2" }
              ],
              "uniforms": [
                { "name": "ModelViewMat", "type": "matrix4x4", "count": 16, "values": [1.0,0.0,0.0,0.0, 0.0,1.0,0.0,0.0, 0.0,0.0,1.0,0.0, 0.0,0.0,0.0,1.0] },
                { "name": "ProjMat", "type": "matrix4x4", "count": 16, "values": [1.0,0.0,0.0,0.0, 0.0,1.0,0.0,0.0, 0.0,0.0,1.0,0.0, 0.0,0.0,0.0,1.0] },
                { "name": "PoseMat", "type": "matrix4x4", "count": 16, "values": [1.0,0.0,0.0,0.0, 0.0,1.0,0.0,0.0, 0.0,0.0,1.0,0.0, 0.0,0.0,0.0,1.0] },
                { "name": "TextureMat", "type": "matrix4x4", "count": 16, "values": [1.0,0.0,0.0,0.0, 0.0,1.0,0.0,0.0, 0.0,0.0,1.0,0.0, 0.0,0.0,0.0,1.0] },
                { "name": "Color", "type": "float", "count": 4, "values": [ 1.0, 1.0, 1.0, 1.0 ] },
                { "name": "UV1", "type": "int", "count": 2, "values": [0, 10] },
                { "name": "UV2", "type": "int", "count": 2, "values": [240, 240] },
                { "name": "Light0_Direction", "type": "float", "count": 3, "values": [0.0, 0.0, 0.0] },
                { "name": "Light1_Direction", "type": "float", "count": 3, "values": [0.0, 0.0, 0.0] },
                { "name": "FogStart", "type": "float", "count": 1, "values": [0.0] },
                { "name": "FogEnd", "type": "float", "count": 1, "values": [1.0] },
                { "name": "FogColor", "type": "float", "count": 4, "values": [0.0,0.0,0.0,0.0] },
                { "name": "FogShape", "type": "int", "count": 1, "values": [0] }
              ]
            }
            """;
    }
}