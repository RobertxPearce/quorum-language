package plugins.quorum.Libraries.Interface.Accessibility.IOS;

import org.robovm.apple.uikit.*;
import org.robovm.apple.uikit.UIAccessibilityContainer;
import org.robovm.apple.uikit.UIAccessibilityTraits;
import quorum.Libraries.Interface.Controls.Button_;
import quorum.Libraries.Interface.Item_;



public class ButtonIOS extends ItemIOS {
    @Override
    public boolean isAccessibilityElement() {
        return true;
    }

    Button_ button;

    public ButtonIOS(UIAccessibilityContainer container)
    {
        super(container);
    }

    public void SetButton(Button_ button)
    {
        this.button = button;
    }

    public void Initialize(Button_ button) {
        SetButton(button);
        UIAccessibilityTraits traits = UIAccessibilityTraits.Button;
        this.setAccessibilityTraits(traits);
        super.Initialize(button);
    }

    @Override
    public boolean activate() {
        button.Activate();
        button.ClickedMouse();
        return true;
    }

}
