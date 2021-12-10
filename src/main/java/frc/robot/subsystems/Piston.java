// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Piston extends SubsystemBase {
  private Compressor c = new Compressor(0);
  private DoubleSolenoid doubleSole = new DoubleSolenoid(0, 1);

  public enum State {
    EXTEND, RETRACT;
  }

  /** Creates a new ExampleSubsystem. */
  public Piston() {
    
  }

  /** Returns the current state of the acquirer pistons */
  public State getState() {
    return doubleSole.get() == Value.kForward ? State.EXTEND : State.RETRACT;
  }

  public void setState(State state) {
    doubleSole.set(state == State.EXTEND ? Value.kForward : Value.kReverse);
  }

  public void toggleState() {
    setState(getState() == State.EXTEND ? State.RETRACT : State.EXTEND);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
