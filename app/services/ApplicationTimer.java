package services;

import java.time.Clock;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import javax.inject.*;

import models.Stadium;
import play.Logger;
import play.inject.ApplicationLifecycle;

/**
 * This class demonstrates how to run code when the
 * application starts and stops. It starts a timer when the
 * application starts. When the application stops it prints out how
 * long the application was running for.
 *
 * This class is registered for Guice dependency injection in the
 * {@link Module} class. We want the class to start when the application
 * starts, so it is registered as an "eager singleton". See the code
 * in the {@link Module} class to see how this happens.
 *
 * This class needs to run code when the server stops. It uses the
 * application's {@link ApplicationLifecycle} to register a stop hook.
 */
@Singleton
public class ApplicationTimer {

    private final Clock clock;
    private final ApplicationLifecycle appLifecycle;
    private final Instant start;

    @Inject
    public ApplicationTimer(Clock clock, ApplicationLifecycle appLifecycle) {
        this.clock = clock;
        this.appLifecycle = appLifecycle;
        // This code is called when the application starts.
        start = clock.instant();
        Logger.info("ApplicationTimer demo: Starting application at " + start);

        //Create 3 stadions at the first start of the application
        Stadium caprica = new Stadium();
        caprica.name = "Caprica";
        caprica.address= "Caprica City";
        caprica.numberOfSeats = 40000;
        caprica.numberOfExits = 50;
        caprica.sponsor= "Gaius Baltar";
        
        Stadium gemenon = new Stadium();
        gemenon.name="Gemenon";
        gemenon.address="Oranu";
        gemenon.numberOfSeats=30000;
        gemenon.numberOfExits=40;
        gemenon.sponsor="Simon O'Neill";
        
        Stadium tauron = new Stadium();
        tauron.name= "Tauron";
        tauron.address="Hypatia";
        tauron.numberOfSeats=40000;
        tauron.numberOfExits=60;
        
   
        // When the application starts, register a stop hook with the
        // ApplicationLifecycle object. The code inside the stop hook will
        // be run when the application stops.
        appLifecycle.addStopHook(() -> {
            Instant stop = clock.instant();
            Long runningTime = stop.getEpochSecond() - start.getEpochSecond();
            Logger.info("ApplicationTimer demo: Stopping application at " + clock.instant() + " after " + runningTime + "s.");
            return CompletableFuture.completedFuture(null);
        });
    }

}
