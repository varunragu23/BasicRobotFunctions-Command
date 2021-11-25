// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int kMotorPort = 7;
    public static final int kJoystickPort = 0;
    public static final int kUltrasonicPort = 0;
    public static final int TalonFXMotor = 10;
    public static final double errorSum = 0.0000;
    public static final double prevError = 0.0000;
    public static final double dTime = 20;
    public static final double TicksPerRotation = 2048;
    public static final double Rotations = 10.0000;
    public static final double dP = 0.00005;
    public static final double dI = 0.000005; // 5
    public static final double dD = 0.000005; // 1
    public static final double Margin = 0.5;
    public static final double errorRange = TicksPerRotation;
}
