package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.Constants;
import org.usfirst.frc.team354.robot.Robot;
import org.usfirst.frc.team354.robot.RobotMap;
import org.usfirst.frc.team354.robot.commands.StopShelf;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shelf extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController shelfMotor;
	private SpeedController rollerMotor;
	private Encoder encoder;
	private DigitalInput raisedSwitch;
	private DigitalInput loweredSwitch;
	
	private static final double MOTOR_SPEED = 0.7;
	private static final double ROLLER_SPEED = 0.6;
	
	private boolean encoderReset = false;
	
	public Shelf() {
		shelfMotor = new Victor(RobotMap.shelfMotor);
		rollerMotor = new Talon(RobotMap.shelfRoller);
		encoder = new Encoder(RobotMap.shelfEncoderA, RobotMap.shelfEncoderB, false, EncodingType.k4X);
		raisedSwitch = new DigitalInput(RobotMap.shelfRaisedSwitch);
		loweredSwitch = new DigitalInput(RobotMap.shelfLoweredSwitch);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopShelf());
    }
    
    public boolean isFullyRaised() {
    	return (!raisedSwitch.get());
    }
    
    public boolean isFullyLowered() {
    	return (!loweredSwitch.get());
    }
    
    public void raise() {
    	if (!isFullyRaised()) {
    		shelfMotor.set(MOTOR_SPEED);
    	}
    	else {
    		shelfMotor.set(0);
    		encoder.reset();
    		encoderReset = true;
    	}
    	
    	SmartDashboard.putNumber(Constants.DASH_SHELF_ENCODER_VALUE, Robot.shelf.encoderValue());
    	SmartDashboard.putBoolean(Constants.DASH_SHELF_ENCODER_OK, Robot.shelf.encoderHasBeenReset());
    }
    
    public void lower() {
    	if (!isFullyLowered()) {
    		shelfMotor.set(-MOTOR_SPEED);
    	}
    	else {
    		shelfMotor.set(0);
    	}
    	
    	SmartDashboard.putNumber(Constants.DASH_SHELF_ENCODER_VALUE, Robot.shelf.encoderValue());
    	SmartDashboard.putBoolean(Constants.DASH_SHELF_ENCODER_OK, Robot.shelf.encoderHasBeenReset());
    }
    
    public void stop() {
    	shelfMotor.set(0);
    }
    
    public void startRollers(boolean reverse) {
    	if (reverse) {
    		rollerMotor.set(-ROLLER_SPEED);
    	}
    	else {
    		rollerMotor.set(ROLLER_SPEED);
    	}
    }
    
    public void startRollers() {
    	startRollers(false);
    }
    
    public void stopRollers() {
    	rollerMotor.set(0);
    }
    
    public int encoderValue() {
    	return encoder.get();
    }
    
    public boolean encoderHasBeenReset() {
    	return encoderReset;
    }
    
    public void initialize() {
    	if (isFullyRaised()) {
    		encoder.reset();
    		encoderReset = true;
    	}
    }
}

