package plugins.quorum.Libraries.Interface.Accessibility.IOS;

import org.robovm.apple.uikit.*;
import quorum.Libraries.Interface.Controls.Button_;
import plugins.quorum.Libraries.Game.GameStateManager;
import quorum.Libraries.Interface.Item_;
import plugins.quorum.Libraries.Game.IOSInput;

public class ButtonIOS extends ItemIOS {
    @Override
    public boolean isAccessibilityElement() {
        return true;
    }

    public ButtonIOS(UIAccessibilityContainer container)
    {
        super(container);
    }

    Button_ button;

    public void Focus(){
        IOSInput input = ((quorum.Libraries.Game.IOSInput) GameStateManager.input).plugin;
        input.AddSingleTapEvent(this); // have to figure out what to pass to function
    }

    public void FocusLost(){
        IOSInput input = ((quorum.Libraries.Game.IOSInput) GameStateManager.input).plugin;
        input.AddSingleTapEvent(null);
    }

    public void SetButton(Button_ button)
    {
        this.button = button;
    }

    public void Initialize(Button_ button) {
        SetButton(button);
        UIAccessibilityTraits traits = UIAccessibilityTraits.Button;

        this.setAccessibilityElement(true);
        this.setAccessibilityLabel("Button.");

        this.setAccessibilityTraits(traits);

        this.setUserInteractionEnabled(true); //added needs more testing

        super.Initialize(button);
    }

    @Override
    public boolean accessibilityActivate(){
        return activate();
    }

    @Override
    public boolean activate() {
        button.Activate();
        return true;
    }
}
