package chanceCubes.rewards.defaultRewards;

import chanceCubes.rewards.IChanceCubeReward;
import chanceCubes.util.RewardsUtil;
import net.minecraft.entity.player.EntityPlayer;
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
        int rewardint = rand.nextInt(6);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
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
                    case 4: {
                        RewardsUtil.executeXCommands("/give @p chancecubes:chance_cube 1", 1, 1);
                    }
                    case 5: {
                        //TODO: Need to add a delay to this will need to speak to turkey about this
//                        player.capabilities.allowFlying = true;
//                        player.sendStatusMessage(new TextComponentString("You can now fly for a few seconds!"),
//                                true);
                    }
                    case 6: {
                        player.setInWeb();
                    }
                    case 7: {
                        // does nothing yet you need to think of something
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
        return -20;
    }

    @Override
    public String getName() {
        return "AnErrorHasOccurredReward";
    }
}
