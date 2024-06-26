// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.autos.*;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.TeleopConveyor;
import frc.robot.commands.TeleopHooks;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /* Controllers */
  private final Joystick driver = new Joystick(0);
  private final Joystick hookCo = new Joystick(1);
  /* Drive Controls */
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;
  private final int hookAxis = XboxController.Axis.kRightY.value;
  private final int leftHookAxis = XboxController.Axis.kLeftY.value;
  //private final int rightTriggerHookCo = XboxController.Axis.kRightTrigger.value;
  //private final int leftTriggerHookCo = XboxController.Axis.kLeftTrigger.value;
  /* Driver Buttons */
  //private final JoystickButton Lifthook = new JoystickButton(driver, XboxController.Button.kA.value);

  /* these are the controller inputs for both drive and shot/climb */

  private final JoystickButton zeroGyro =
      new JoystickButton(driver, XboxController.Button.kY.value);
  private final JoystickButton robotCentric =
      new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
    private final JoystickButton runIntake = 
      new JoystickButton(hookCo, XboxController.Button.kA.value);
  private final JoystickButton shoot =
      new JoystickButton(hookCo, XboxController.Button.kRightBumper.value);
  private final JoystickButton shootAmp =
      new JoystickButton(hookCo, XboxController.Button.kX.value);
  private final JoystickButton reverseConveyor =
      new JoystickButton(hookCo, XboxController.Button.kB.value);
  // private final JoystickButton turbo =
  //     new JoystickButton(driver, XboxController.Button.kA.value);
  /* Subsystems */
  private final Swerve s_Swerve = new Swerve();

  private final Hooks h_hook = new Hooks();

  private final Conveyor c_Conveyor = new Conveyor();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    s_Swerve.setDefaultCommand(
        new TeleopSwerve(
            s_Swerve,
            () -> driver.getRawAxis(translationAxis),
            () -> driver.getRawAxis(strafeAxis),
            () -> driver.getRawAxis(rotationAxis),
            () -> robotCentric.getAsBoolean()
            /*() -> turbo.getAsBoolean()*/));
            
   
    h_hook.setDefaultCommand(
      new TeleopHooks(
        h_hook,
        () -> hookCo.getRawAxis(hookAxis),
        () -> hookCo.getRawAxis(leftHookAxis)));
      
    // c_Conveyor.setDefaultCommand(
    //   new TeleopConveyor(
    //     c_Conveyor, 
    //     () -> hookCo.getRawAxis(rightTriggerHookCo),
    //     () -> hookCo.getRawAxis(leftTriggerHookCo)));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /* Driver Buttons */
    zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
    // Lifthook.onTrue(/* maxExtend(go)*/ );
    runIntake.onTrue(new InstantCommand(() -> c_Conveyor.runIntake()));
    
    runIntake.onFalse(new InstantCommand(() -> c_Conveyor.stopIntake()));

    shoot.onTrue(new InstantCommand(() -> c_Conveyor.shoot()));

    shoot.onFalse(new InstantCommand(() -> c_Conveyor.dontShoot()));

    shootAmp.onTrue(new InstantCommand(() -> c_Conveyor.runConveyor()));

    shootAmp.onFalse(new InstantCommand(() -> c_Conveyor.stopConveyor()));

    reverseConveyor.onTrue(new InstantCommand(() -> c_Conveyor.reverseConveyor()));

    reverseConveyor.onFalse(new InstantCommand(() -> c_Conveyor.dontReverse()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return new exampleAuto(s_Swerve);
    //return new inFrontAuto(s_Swerve, c_Conveyor);
    return new moreStupidAuto(s_Swerve, c_Conveyor);
  }
}
