package com.hbm.render.material;

import com.hbm.main.NuclearTechMod;
import com.hbm.render.util.NtmShaders.NtmVertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MaterialShaderCache {

    private static final Map<Material, ShaderInstance> CACHE = new ConcurrentHashMap<>();

    public static ShaderInstance get(Material material) {
        return CACHE.computeIfAbsent(material, MaterialShaderCache::compile);
    }

    private static ShaderInstance compile(Material material) {
        String vsh = MaterialShaderSource.vertex(material);
        String fsh = MaterialShaderSource.fragment(material);
        String json = MaterialShaderSource.json();

        GeneratedShaderResources resources = new GeneratedShaderResources(Minecraft.getInstance().getResourceManager());
        resources.put(NuclearTechMod.withDefaultNamespace("shaders/core/generated.json"), json);
        resources.put(NuclearTechMod.withDefaultNamespace("shaders/core/generated.vsh"), vsh);
        resources.put(NuclearTechMod.withDefaultNamespace("shaders/core/generated.fsh"), fsh);

        try {
            return new ShaderInstance(resources, NuclearTechMod.withDefaultNamespace("generated"), NtmVertexFormat.POSITION_TEX_NORMAL);
        } catch(IOException e) {
            throw new IllegalStateException("Shader compile failed " + material, e);
        }
    }
}