package plugins.quorum.Libraries.Interface.Accessibility.IOS;

import org.robovm.apple.uikit.UIAccessibilityContainer;
import org.robovm.apple.uikit.UIAccessibilityTraits;
import org.robovm.apple.uikit.UIKeyInput;
import plugins.quorum.Libraries.Game.GameStateManager;
import plugins.quorum.Libraries.Game.IOSInput;
import quorum.Libraries.Interface.Controls.TextBox_;
import quorum.Libraries.Interface.Controls.TextField_;

public class TextBoxIOS extends TextAdjust implements UIKeyInput {

    public boolean isAccessibilityElement() {
        return true;
    }
    public TextBoxIOS(UIAccessibilityContainer container)
    {
        super(container);
    }

    public void Initialize(TextField_ field) {
        UIAccessibilityTraits traits = UIAccessibilityTraits.SearchField;
        this.setAccessibilityTraits(traits);
        super.Initialize(field);
    }

    public void Focus() {
        IOSInput input = ((quorum.Libraries.Game.IOSInput) GameStateManager.input).plugin_;
        input.setFocusedTextAdjust(this);
        input.setOnscreenKeyboardVisible(true);

        becomeFirstResponder();
    }

    public void FocusLost() {
        IOSInput input = ((quorum.Libraries.Game.IOSInput) GameStateManager.input).plugin_;
        input.setFocusedTextAdjust(null);
        input.setOnscreenKeyboardVisible(false);

        resignFirstResponder();
    }

    public TextBox_ GetTextBox() {
        TextBox_ box = (TextBox_) GetItem();
        return box;
    }

    @Override
    public boolean canBecomeFirstResponder() {
        return true;
    }

    @Override
    public boolean hasText(){
        return GetText() != null && !GetText().isEmpty();
    }

    @Override
    public void insertText(String string) {
        GetTextBox().Insert(string);
    }

    @Override
    public void deleteBackward() {
        GetTextBox().DeleteBackward();
    }

    public String GetText() {
        return GetTextBox().GetText();
    }
}
