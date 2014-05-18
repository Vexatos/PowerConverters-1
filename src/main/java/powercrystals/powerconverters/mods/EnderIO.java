package powercrystals.powerconverters.mods;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import powercrystals.powerconverters.PowerConverterCore;
import powercrystals.powerconverters.mods.base.LoaderBase;
import powercrystals.powerconverters.power.PowerSystem;
import powercrystals.powerconverters.power.enderio.BlockPowerConverterRF;
import powercrystals.powerconverters.power.enderio.ItemBlockPowerConverterRF;
import powercrystals.powerconverters.power.enderio.TileEntityRFConsumer;
import powercrystals.powerconverters.power.enderio.TileEntityRFProducer;
import cpw.mods.fml.common.registry.GameRegistry;


public final class EnderIO extends LoaderBase
{
    public static final EnderIO INSTANCE = new EnderIO();

    public BlockPowerConverterRF converterBlock;
    public PowerSystem powerSystem;

    private EnderIO()
    {
    	super("EnderIO");
    }

    @Override
    protected void preInit()
    {
    	powerSystem = new PowerSystem("EnderIO", "RF", 437.5F, 437.5F, null, null, "RF/t");
    	PowerSystem.registerPowerSystem(powerSystem);
    }

    @Override
    protected void init()
    {
    	converterBlock = new BlockPowerConverterRF(PowerConverterCore.blockIdEnderIO);
    	GameRegistry.registerBlock(converterBlock, ItemBlockPowerConverterRF.class, converterBlock.getUnlocalizedName());
    	GameRegistry.registerTileEntity(TileEntityRFConsumer.class, "powerConverterRFConsumer");
    	GameRegistry.registerTileEntity(TileEntityRFProducer.class, "powerConverterRFProducer");
    }

    @Override
    protected void postInit()
    {
    	GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 1), new ItemStack(converterBlock, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 0), new ItemStack(converterBlock, 1, 1));
    	
    	try
    	{
    		if (EnderIO.INSTANCE.powerSystem.getRecipesEnabled())
    		{
    			GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 1), new Object[] { new ItemStack(converterBlock, 1, 0) });
    			GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 0), new Object[] { new ItemStack(converterBlock, 1, 1) });
		
    			if (PowerConverterCore.powerSystemSteamEnabled)
    			{
    				GameRegistry.addRecipe(new ItemStack(converterBlock, 1, 0), new Object[] { "G G", " T ", "G G", Character.valueOf('G'), Items.gold_ingot, Character.valueOf('T'),  GameRegistry.findItemStack( "EnderIO", "blockCapacitorBank", 1 )});
    			}
	    		}
			} 
	
		catch (Throwable t)
		{
			t.printStackTrace(System.err);
		}
    }
}
