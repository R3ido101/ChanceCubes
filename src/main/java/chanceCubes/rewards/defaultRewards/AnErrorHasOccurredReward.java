package chanceCubes.rewards.defaultRewards;

import chanceCubes.rewards.IChanceCubeReward;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class AnErrorHasOccurredReward implements IChanceCubeReward {
    @Override
    public void trigger(World world, BlockPos pos, EntityPlayer player) throws InterruptedException {
        player.sendMessage(new TextComponentString("There has seemed to be a error. " +
                "Please hold while we fix this..."));
        Thread.sleep(12000);
        Random rand = new Random();
        int rewardint = rand.nextInt(2);
        player.sendMessage(new TextComponentString("Ahh.. we have it working again lets try this!"));

        switch (rewardint) {
            case 0: {
                player.setHealth(1);
            }
            case 1: {
                player.setPortal(pos);
            }
            case 3: {
                world.setWorldTime(14000);
            }
        }

    }

    @Override
    public int getChanceValue() {
        return -20;
    }

    @Override
    public String getName() {
        return "AnErrorHasOccurredReward";
    }
}
