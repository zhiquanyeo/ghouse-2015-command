package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.RobotMap;
import org.usfirst.frc.team354.robot.commands.StopLift;

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
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController liftMotor;
	private SpeedController rollerMotor;
	private Encoder encoder;
	private DigitalInput topSwitch;
	private DigitalInput bottomSwitch;
	
	private static final double MOTOR_SPEED = 1.0;
	private static final double ROLLER_SPEED = 0.6;
	
	private boolean encoderReset = false;
	
	public Lift() {
		liftMotor = new Victor(RobotMap.liftMotor);
		rollerMotor = new Talon(RobotMap.liftRoller);
		encoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB, false, EncodingType.k4X);
		topSwitch = new DigitalInput(RobotMap.liftTopSwitch);
		bottomSwitch = new DigitalInput(RobotMap.liftBottomSwitch);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopLift());
    }
    
    public void raise() {
    	if (!isAtTop()) {
    		liftMotor.set(MOTOR_SPEED);
    	}
    	else {
    		liftMotor.set(0);
    	}
    }
    
    public void lower() {
    	if (!isAtBottom()) {
    		liftMotor.set(-MOTOR_SPEED);
    	}
    	else {
    		liftMotor.set(0);
    		encoder.reset();
    		encoderReset = true;
    	}
    }
    
    public void stop() {
    	liftMotor.set(0);
    }
    
    public boolean isAtTop() {
    	return (!topSwitch.get());
    }
    
    public boolean isAtBottom() {
    	return (!bottomSwitch.get());
    }
    
    public int encoderValue() {
    	return encoder.get();
    }
    
    public boolean encoderHasBeenReset() {
    	return encoderReset;
    }
    
    public void startRollers() {
    	
    }
    
    public void stopRollers() {
    	
    }
}

