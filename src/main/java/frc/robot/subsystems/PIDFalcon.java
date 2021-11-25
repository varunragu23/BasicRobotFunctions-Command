// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class PIDFalcon extends PIDSubsystem {
  private final WPI_TalonFX falcon = new WPI_TalonFX(Constants.TalonFXMotor);
  TalonFXConfiguration configs = new TalonFXConfiguration();

  /** Creates a new PIDFalcon. */
  public PIDFalcon() {
    super(
        // The PIDController used by the subsystem
        new PIDController(Constants.dP, Constants.dI, Constants.dD));    
      
    falcon.configFactoryDefault();


    configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;
    /* config all the settings */
    falcon.configAllSettings(configs);
    getController().setIntegratorRange(-1024, 1024);


    falcon.setSelectedSensorPosition(0);
    setSetpoint(0.0);
    System.out.println(getSetpoint());    
  }

  @Override
  public void useOutput(double output, double setpoint) {
    double speed = Math.max(Math.min(output, 0.1), -0.1);
    falcon.set(TalonFXControlMode.PercentOutput, speed);
  }

  @Override
  public double getMeasurement() {
    return falcon.getSelectedSensorPosition(0);
  }

@Override
public void periodic() {
  // TODO Auto-generated method stub
  super.periodic();
  double pos = (double)falcon.getSelectedSensorPosition(0) / Constants.TicksPerRotation;
  SmartDashboard.putNumber("pos ", pos);

}

public void setSpeedManual(double speed) {
  falcon.set(TalonFXControlMode.PercentOutput, 0.1);

}

}
