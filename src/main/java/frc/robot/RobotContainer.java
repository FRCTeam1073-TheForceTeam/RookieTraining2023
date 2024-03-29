// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.BlingSetCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Bling;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.OI;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {// The robot's subsystems and commands are defined here...
  DrivetrainSubsystem m_drivetrainsubsystem = new DrivetrainSubsystem();
  OI m_OI = new OI();
  Bling m_bling = new Bling();
  DriveCommand m_driveCommand = new DriveCommand(m_drivetrainsubsystem, m_OI);
  BlingSetCommand m_blingSetCommand = new BlingSetCommand(m_bling, m_OI);
  SequentialCommandGroup fullAuto;
  SendableChooser<Command> comboBChooser;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    CommandScheduler.getInstance().setDefaultCommand(m_drivetrainsubsystem, m_driveCommand);
    // CommandScheduler.getInstance().setDefaultCommand(m_bling, m_blingSetCommand);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return null;
    fullAuto =
    new SequentialCommandGroup(
    comboBChooser.getSelected());

    return fullAuto;
  } 
}
  