package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.RobotMap;
import org.usfirst.frc.team354.robot.commands.StopShelf;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

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
    }
    
    public void lower() {
    	if (!isFullyLowered()) {
    		shelfMotor.set(-MOTOR_SPEED);
    	}
    	else {
    		shelfMotor.set(0);
    	}
    }
    
    public void stop() {
    	shelfMotor.set(0);
    }
    
    public void startRollers() {
    	
    }
    
    public void stopRollers() {
    	
    }
    
    public int encoderValue() {
    	return encoder.get();
    }
    
    public boolean encoderHasBeenReset() {
    	return encoderReset;
    }
}

