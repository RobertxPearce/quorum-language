package plugins.quorum.Libraries.Interface.Accessibility.IOS;

import org.robovm.apple.uikit.*;
import quorum.Libraries.Interface.Controls.RadioButton_;
import quorum.Libraries.Interface.Controls.ToggleButton_;
import quorum.Libraries.Interface.Item_;
public class RadioButtonIOS extends ItemIOS {
    @Override
    public boolean isAccessibilityElement() {
        return true;
    }

    public RadioButtonIOS(UIAccessibilityContainer container) {
        super(container);
    }

    RadioButton_ radioButton;

    public void setRadioButton(RadioButton_ radioButton) {
        this.radioButton = radioButton;
    }

    public void Initialize(RadioButton_ radioButton) {
        setRadioButton(radioButton);
        UIAccessibilityTraits traits = UIAccessibilityTraits.None;
        this.setAccessibilityTraits(traits);
        super.Initialize(radioButton);
    }

    @Override
    public boolean activate() {

///////////////Aidan and Nirbhay worked on this in a call///////////////
        boolean isToggled = radioButton.GetToggleState();
        if(isToggled){
            radioButton.Activate();
            radioButton.ClickedMouse();
            radioButton.SetToggleState(false);
            return false;
        }
        else{
            radioButton.Activate();
            radioButton.ClickedMouse();
            radioButton.SetToggleState(true);
            return true;
        }

    }
}
