package guitests.guihandles;

import java.net.URL;
import java.util.Set;

import guitests.GuiRobot;
import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import seedu.address.model.table.Table;

/**
 * A handler for the {@code BrowserPanel} of the UI.
 */
public class TablesFlowPanelHandle extends NodeHandle<FlowPane> {

    public static final String TABLES_FLOW_PANEL_ID = "#tablesFlowPanel";

    private static final String CARD_PANE_ID = "#cardPane";

    public TablesFlowPanelHandle(FlowPane tablesPanelNode) {
        super(tablesPanelNode);
    }

    /**
     * Returns all card nodes in the scene graph.
     * Card nodes that are visible in the flowpane are definitely in the scene graph, while some nodes that are not
     * visible in the flowpane may also be in the scene graph.
     */
    private Set<Node> getAllCardNodes() {
        return guiRobot.lookup(CARD_PANE_ID).queryAll();
    }

    //    private Table getTable(int index) {// TODO: figure out if we need this.
    //        return getRootNode().getChildren().get(index);
    //    }
    //
    //    /**
    //     * Returns the table card handle of a table associated with the {@code index} in the list.
    //     * @throws IllegalStateException if the selected card is currently not in the scene graph.
    //     */
    //    public TableCardHandle getTableCardHandle(int index) {
    //        return getAllCardNodes().stream()
    //                .map(TableCardHandle::new)
    //                .filter(handle -> handle.equals(getTable(index)))
    //                .findFirst()
    //                .orElseThrow(IllegalStateException::new);
    //    }
}
