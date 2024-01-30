// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//import ctre libraries through manage vendor libraries with https://maven.ctr-electronics.com/release/com/ctre/phoenixpro/PhoenixProAnd5-frc2023-latest.json

package frc.robot.subsystems;
// import com.ctre.phoenix6.motorcontrol.ControlMode;
// import com.ctre.phoenix6.motorcontrol.FeedbackDevice;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  // Define devices here:
  public TalonFX testMotor;
  TalonFXConfiguration testmotor_cfg = new TalonFXConfiguration();
  public int ticksPerRevolution = 2048;
  final VoltageOut m_request = new VoltageOut(0);

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    // Initialize devices here:
    testMotor = new TalonFX(46);
    testmotor_cfg.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.RotorSensor;
    testMotor.getConfigurator().apply(testmotor_cfg);
    // testMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    testMotor.setPosition(0);

    SmartDashboard.putNumber("Motor Percent Output", getVelocity());

  }

  public double getPosition() {
    return 1.0; //testMotor.getSelectedSensorPosition() * (2 * Math.PI) / ticksPerRevolution;
  }

  public double getVelocity() {
    return 1.0; //testMotor.getSelectedSensorVelocity() * (2 * Math.PI) * 10.0 / ticksPerRevolution;
  }

  public double getMotorTemperature() {
    return 1.0; //testMotor.getTemperature();
  }

  public void setPower(double power) {
    testMotor.setControl(m_request.withOutput(12.0 * power));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Motor Velocity", getVelocity());
    SmartDashboard.putNumber("Motor Position", getPosition());
    SmartDashboard.putNumber("Motor Temperature", getMotorTemperature());
    //power = SmartDashboard.getNumber("Motor Percent Output", power);

  }
}