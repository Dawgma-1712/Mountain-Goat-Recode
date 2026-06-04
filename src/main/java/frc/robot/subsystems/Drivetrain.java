package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.IdConstants;

import java.util.function.Supplier;

public class Drivetrain extends SubsystemBase {
    
    private final Spark topLeft = new Spark(IdConstants.topLeft);
    private final Spark bottomLeft = new Spark(IdConstants.bottomLeft);
    private final Spark topRight = new Spark(IdConstants.topRight);
    private final Spark bottomRight = new Spark(IdConstants.bottomRight);

    public Drivetrain() {

    }

    public void drive(double[] speeds) {
        bottomLeft.set(speeds[1]);
        topRight.set(speeds[2]);
        bottomRight.set(speeds[3]);
    }

    public Command drivetrainCMDFactory(Supplier<Double> driveSpd, Supplier<Double> turnSpd) {
        return this.run(() -> {
            double left = (driveSpd.get() + turnSpd.get()) * 0.5;
            double right = (driveSpd.get() - turnSpd.get()) * 0.5;
            double[] motorSpeeds = {left, -left, right, -right};
            drive(motorSpeeds);
        }
        );
    }

}
