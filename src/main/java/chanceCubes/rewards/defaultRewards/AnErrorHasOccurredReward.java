package chanceCubes.rewards.defaultRewards;

import chanceCubes.CCubesCore;
import chanceCubes.blocks.BlockChanceCube;
import chanceCubes.blocks.CCubesBlocks;
import chanceCubes.rewards.IChanceCubeReward;
import chanceCubes.util.RewardsUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class AnErrorHasOccurredReward implements IChanceCubeReward {
    @Override
    public void trigger(World world, BlockPos pos, EntityPlayer player) throws InterruptedException {
        Random rand = new Random();
        int rewardint = rand.nextInt(5);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                player.sendMessage(new TextComponentString("Ahh.. we have it working again lets try this!"));

                switch (rewardint) {
                    case 0: {
                        player.setHealth(1);

                    }
                    case 1: {
                        RewardsUtil.executeCommand(world, player, "/give @p chancecubes:chance_cube 6");
                        player.sendMessage(new TextComponentString("Here have another six!"));
                    }
                    case 3: {
                        world.setWorldTime(14000);
                    }
                    case 4: {
                        RewardsUtil.executeCommand(world, player, "/give @p chancecubes:chance_cube 1");
                    }
                }
            }
        };

        player.sendMessage(new TextComponentString("There has seemed to be a error. " +
                "Please hold while we fix this..."));
        Timer timer = new Timer();
        timer.schedule(task, 12000);


    }

    @Override
    public int getChanceValue() {
        return -24;
    }

    @Override
    public String getName() {
        return CCubesCore.MODID + ":AnErrorHasOccurredReward";
    }
}
