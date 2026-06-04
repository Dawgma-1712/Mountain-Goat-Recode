package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.IdConstants;

public class Launcher extends SubsystemBase {

    private final Spark launchMotor = new Spark(IdConstants.launchMotor);

    public Launcher() {

    }

    public void shoot(double speed) {
        launchMotor.set(speed);
    }

     public Command launchCMDFactory(double speed) {
        return this.run(() -> {
            shoot(speed);
        }
        );
    }


    
}
