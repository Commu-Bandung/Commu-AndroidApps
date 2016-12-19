package Modules;

import java.util.List;

/**
 * Created by Firman on 12/19/2016.
 */

public interface DirectionFinderListener {

    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
