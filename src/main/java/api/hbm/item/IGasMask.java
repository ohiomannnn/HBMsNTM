package api.hbm.item;

import com.hbm.util.ArmorRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public interface IGasMask {

    /**
     * Returns a list of HazardClasses which can not be protected against by this mask (e.g. chlorine gas for half masks)
     * @param stack
     * @param entity
     * @return an empty list if there's no blacklist
     */
    public ArrayList<ArmorRegistry.HazardClass> getBlacklist(ItemStack stack, LivingEntity entity);

    /**
     * Returns the loaded filter, if there is any
     * @param stack
     * @param entity
     * @return null if no filter is installed
     */
    public ItemStack getFilter(ItemStack stack, LivingEntity entity);

    /**
     * Checks whether the provided filter can be screwed into the mask, does not take already applied filters into account (those get ejected)
     * @param stack
     * @param entity
     * @param filter
     * @return
     */
    public boolean isFilterApplicable(ItemStack stack, LivingEntity entity, ItemStack filter);

    /**
     * This will write the filter to the stack's NBT, it ignores any previously installed filter and won't eject those
     * @param stack
     * @param entity
     * @param filter
     */
    public void installFilter(ItemStack stack, LivingEntity entity, ItemStack filter);

    /**
     * Damages the installed filter, if there is one
     * @param stack
     * @param entity
     * @param damage
     */
    public void damageFilter(ItemStack stack, LivingEntity entity, int damage);
}