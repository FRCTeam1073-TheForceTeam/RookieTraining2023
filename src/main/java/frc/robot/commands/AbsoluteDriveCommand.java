// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AbsoluteDriveCommand extends CommandBase {
  DrivetrainSubsystem drivetrain;
  public double power = 0.0;
  public double initialPos = 0.0;
  public double desiredPos = 2.0;
  public double currentPos;
  public double radiansToSpin;
  //public WPI_TalonFX testMotor;
  //public int ticksPerRecolution = 2048;
  double distance;

  /** Creates a new InputDriveCommand2. */
  public AbsoluteDriveCommand(DrivetrainSubsystem drivetrain, double radiansToSpin, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.radiansToSpin = radiansToSpin;
    this.power = power;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    distance = 0;
    power = 0.5;
    initialPos = drivetrain.getPosition();
    drivetrain.setPower(drivetrain.power);
    desiredPos = initialPos + radiansToSpin;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentPos = drivetrain.getPosition();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return(currentPos >= desiredPos);
  }
}
