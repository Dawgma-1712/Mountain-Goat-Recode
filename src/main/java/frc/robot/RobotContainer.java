// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Joystick joystick = new Joystick(0);
  private final Launcher launcher = new Launcher();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    drivetrain.setDefaultCommand(drivetrain.drivetrainCMDFactory(() -> -joystick.getRawAxis(0), () -> joystick.getRawAxis(1)));
    intake.setDefaultCommand(intake.intakeCMDFactory(0));
    launcher.setDefaultCommand(launcher.launchCMDFactory(0));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`.
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    new JoystickButton(joystick, 5)
    .whileTrue(intake.intakeCMDFactory(1));

    new JoystickButton(joystick, 6)
    .whileTrue(intake.intakeCMDFactory(-1));

    new JoystickButton(joystick, 7)
    .whileTrue(launcher.launchCMDFactory(1.0));

    new JoystickButton(joystick, 8)
    .whileTrue(launcher.launchCMDFactory(-1.0));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}




/* ajfiwuefhaweiojfiawjeo;fiajwo;eifjao;iwejfo;iajwe;oifja;oiwejf;oaiwejf;oiajwe;oifja;oweijfa;oiwejf;oaiwje;ofiajwe;oifja;oiwejfo;iawejf;oiajwe;oifja;oiwejfa;oiwejf;oiajwe;oifja;woiejfa;oiwej;foiajwe;oifaiowejfoiajweoifjeiofjijijijiejfiejfiejfiejoifjeoiwfjoiejfoiwejfoiwejwfhefwaijojaiojiofajiew;fojiewafjofwijo;ewfjoifojijweoifijoeijougyhjioijhugyijohjkuhygtfyghnygtfuhgyfghjnhbgbjnknjhbgjnhbbnjhgfhjhugyhjhugyhuygfguiygtfyguytduigytfxguibh */