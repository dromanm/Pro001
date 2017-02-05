package hw6.notes.view.controller.edit;

import hw6.notes.service.NotebookService;

/**
 * Created by eriol4ik on 04/02/2017.
 */
public interface EditController {
    void setService(NotebookService service);

    boolean isChanged();
}
