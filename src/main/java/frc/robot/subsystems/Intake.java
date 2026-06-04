package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.IdConstants;


public class Intake extends SubsystemBase {

    private final Spark intakeMotor = new Spark(IdConstants.intakeMotor);

    public Intake() {

    }

    public void shoot(double speed) {
        intakeMotor.set(speed);
    }

     public Command intakeCMDFactory(double speed) {
        return this.run(() -> {
            shoot(speed);
        }
        );
    }


    
}
