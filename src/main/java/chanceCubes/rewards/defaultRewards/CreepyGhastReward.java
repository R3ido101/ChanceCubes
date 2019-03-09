package chanceCubes.rewards.defaultRewards;

import chanceCubes.CCubesCore;
import chanceCubes.rewards.IChanceCubeReward;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class CreepyGhastReward implements IChanceCubeReward {
    @Override
    public void trigger(World world, BlockPos pos, EntityPlayer player) throws InterruptedException {
        Random random = new Random();
        int rewardint = random.nextInt(1);

        switch (rewardint) {
            case 0: {

                player.sendMessage(new TextComponentString("[Mysterious Shadow] " + player.getName() +
                        " I am watching you!"));
                //zplayer.playSound(SoundEvents.ENTITY_GHAST_WARN, 100, 0);
                player.playSound(SoundEvents.ENTITY_GHAST_AMBIENT, 100, 5);
            }
            case 1: {

            }
        }
    }

    @Override
    public int getChanceValue() {
        return -50;
    }

    @Override
    public String getName() {
        return CCubesCore.MODID + ":CreepyGhastReward";
    }
}
