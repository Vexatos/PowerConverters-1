package powercrystals.powerconverters.mods;

import ic2.core.Ic2Items;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import powercrystals.powerconverters.PowerConverterCore;
import powercrystals.powerconverters.common.TileEntityCharger;
import powercrystals.powerconverters.mods.base.LoaderBase;
import powercrystals.powerconverters.power.PowerSystem;
import powercrystals.powerconverters.power.ic2.BlockPowerConverterIndustrialCraft;
import powercrystals.powerconverters.power.ic2.ChargeHandlerIndustrialCraft;
import powercrystals.powerconverters.power.ic2.ItemBlockPowerConverterIndustrialCraft;
import powercrystals.powerconverters.power.ic2.TileEntityIndustrialCraftConsumer;
import powercrystals.powerconverters.power.ic2.TileEntityIndustrialCraftProducer;
import cpw.mods.fml.common.registry.GameRegistry;

public final class IndustrialCraft extends LoaderBase
{
    public static final IndustrialCraft INSTANCE = new IndustrialCraft();

    public BlockPowerConverterIndustrialCraft converterBlock;
    public PowerSystem powerSystem;

    private IndustrialCraft()
    {
    	super("IC2");
    }

    @Override
    protected void preInit()
    {
    	powerSystem = new PowerSystem("IndustrialCraft", "IC2", 4000, 4000,/*1800, 1800,*/new String[] { "LV", "MV", "HV", "EV", "AV" }, new int[] { 32, 128, 512, 2048, 8192 }, "EU/t");
    	PowerSystem.registerPowerSystem(powerSystem);
    	TileEntityCharger.registerChargeHandler(new ChargeHandlerIndustrialCraft());
    }

    @Override
    protected void init()
    {
    	converterBlock = new BlockPowerConverterIndustrialCraft(PowerConverterCore.blockIdIndustrialCraft);
    	GameRegistry.registerBlock(converterBlock, ItemBlockPowerConverterIndustrialCraft.class, converterBlock.getUnlocalizedName());
    	GameRegistry.registerTileEntity(TileEntityIndustrialCraftConsumer.class, "powerConverterIC2Consumer");
    	GameRegistry.registerTileEntity(TileEntityIndustrialCraftProducer.class, "powerConverterIC2Producer");
    }

    @Override
    protected void postInit()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 1), new ItemStack(converterBlock, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 0), new ItemStack(converterBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 3), new ItemStack(converterBlock, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 2), new ItemStack(converterBlock, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 5), new ItemStack(converterBlock, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 4), new ItemStack(converterBlock, 1, 5));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 7), new ItemStack(converterBlock, 1, 6));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 6), new ItemStack(converterBlock, 1, 7));
        GameRegistry.addShapelessRecipe(new ItemStack(converterBlock, 1, 9), new ItemStack(converterBlock, 1, 8));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(converterBlock, 1, 0), true, new Object[]
        {
                "CPC",
                "PTP",
                "CPC",
                'C', Ic2Items.insulatedTinCableItem,
                'P', PowerConverterCore.tryOreDict("plateTin", Ic2Items.platetin),
                'T', Ic2Items.lvTransformer
        })
        
        );
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(converterBlock, 1, 2), true, new Object[]
        {
                "CPC",
                "PTP",
                "CPC",
                'C', Ic2Items.insulatedCopperCableItem,
                'P', PowerConverterCore.tryOreDict("plateCopper", Ic2Items.platecopper),
                'T', Ic2Items.mvTransformer
        })
        
        );
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(converterBlock, 1, 4), true, new Object[]
        {
                "CPC",
                "PTP",
                "CPC",
                'C', Ic2Items.insulatedGoldCableItem,
                'P', PowerConverterCore.tryOreDict("plateGold", Ic2Items.plategold),
                'T', Ic2Items.hvTransformer
        })
        
        );
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(converterBlock, 1, 6), true, new Object[]
        {
                "CPC",
                "PTP",
                "CPC",
                'C', Ic2Items.insulatedIronCableItem,
                'P', PowerConverterCore.tryOreDict("plateIron", Ic2Items.plateiron),
                'T', Ic2Items.evTransformer
        })
        
        );
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(converterBlock, 1, 8), true, new Object[]
        {
                "CPC",
                "PTP",
                "CPC",
                'C', Ic2Items.energyCrystal,
                'P', PowerConverterCore.tryOreDict("plateLapis", Ic2Items.platelapi),
                'T', Ic2Items.evTransformer
        })
        
        );
        
        ItemStack fluid = new ItemStack(Ic2Items.ejectorUpgrade.getItem(), 1, 4);
        ItemStack storage = Ic2Items.batBox;
        ItemStack cable = Ic2Items.insulatedGoldCableItem;
        Object tin = PowerConverterCore.tryOreDict("plateTin", Ic2Items.platetin);
        Object bronze = PowerConverterCore.tryOreDict("plateBronze", Ic2Items.platebronze);
        ItemStack charger = Ic2Items.RTGenerator;
        ItemStack transmit = Ic2Items.insulatedIronCableItem;
        
        if (IndustrialCraft.INSTANCE.powerSystem.getRecipesEnabled())
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PowerConverterCore.converterBlockCommon, 1, 0), true, new Object[]
            {
            		"CTC",
                    "SDS",
                    "CTC",
                    'C', cable,
                    'T', tin,
                    'S', storage,
                    'D', Items.diamond
            })
            
            );
            
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PowerConverterCore.converterBlockCommon, 1, 2), true, new Object[]
            {
                    "T#T",
                    "CSC",
                    "TCT",
                    'T', transmit,
                    'C', cable,
                    'S', Blocks.chest,
                    '#', charger
            })
            
            );
            
            if (PowerConverterCore.powerSystemSteamEnabled) 
            {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PowerConverterCore.converterBlockSteam, 1, 0), true, new Object[]
                {
                        "CPC",
                        "PTP",
                        "CPC",
                        'C', Ic2Items.FluidCell,
                        'P', bronze,
                        'T', fluid
                })
                
                );
            }
        }
    }
}
