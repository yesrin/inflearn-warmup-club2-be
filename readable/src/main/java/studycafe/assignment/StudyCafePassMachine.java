package readable.src.main.java.studycafe.assignment;



import readable.src.main.java.studycafe.assignment.exception.AppException;
import readable.src.main.java.studycafe.assignment.io.InputHandler;
import readable.src.main.java.studycafe.assignment.io.OutputHandler;
import readable.src.main.java.studycafe.assignment.io.StudyCafeFileHandler;
import readable.src.main.java.studycafe.assignment.model.StudyCafeLockerPass;
import readable.src.main.java.studycafe.assignment.model.StudyCafePass;
import readable.src.main.java.studycafe.assignment.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            StudyCafePass selectedPass = getStudyCafePass(studyCafePassType);

            if (studyCafePassType == StudyCafePassType.FIXED) {
                List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();
                StudyCafeLockerPass lockerPass = lockerPasses.stream()
                    .filter(option ->
                        option.getPassType() == selectedPass.getPassType()
                            && option.getDuration() == selectedPass.getDuration()
                    )
                    .findFirst()
                    .orElse(null);

                boolean lockerSelection = false;
                if (lockerPass != null) {
                    outputHandler.askLockerPass(lockerPass);
                    lockerSelection = inputHandler.getLockerSelection();
                }

                if (!lockerSelection) {
                    outputHandler.showPassOrderSummary(selectedPass, lockerPass);
                }

                outputHandler.showPassOrderSummary(selectedPass, null);
            }
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePass getStudyCafePass(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
        List<StudyCafePass> targetPasses = studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
            .toList();
        outputHandler.showPassListForSelection(targetPasses);
        StudyCafePass selectedPass = inputHandler.getSelectPass(targetPasses);
        return selectedPass;
    }

}
