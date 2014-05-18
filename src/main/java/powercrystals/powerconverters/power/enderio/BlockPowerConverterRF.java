package powercrystals.powerconverters.power.enderio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import powercrystals.powerconverters.PowerConverterCore;
import powercrystals.powerconverters.gui.PCCreativeTab;
import powercrystals.powerconverters.power.BlockPowerConverter;

/**
 * @author samrg472
 */
public class BlockPowerConverterRF extends BlockPowerConverter 
{
    public BlockPowerConverterRF(int blockId) 
    {
        super(blockId, 2);
        setBlockName("powerconverters.te");
        setCreativeTab(PCCreativeTab.tab);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) 
    {
      
    	if (metadata == 0)
    		return new TileEntityRFConsumer();
      
    	else if (metadata == 1) 
    	{
    		return new TileEntityRFProducer();
    	}
     
    	return createNewTileEntity(world, metadata);
    
    	}
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) 
    {
      _icons[0] = ir.registerIcon("PowerConverters:" + getUnlocalizedName() + ".consumer.off");
      _icons[1] = ir.registerIcon("PowerConverters:" + getUnlocalizedName() + ".consumer.on");
      _icons[2] = ir.registerIcon("PowerConverters:" + getUnlocalizedName() + ".producer.off");
      _icons[3] = ir.registerIcon("PowerConverters:" + getUnlocalizedName() + ".producer.on");
    }
  }
