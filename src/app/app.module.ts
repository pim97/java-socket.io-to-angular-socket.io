import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { SocketService } from "./socket-service.service";
import { ContentComponent } from "./content/content.component";
import { FooterComponent } from "./footer/footer.component";
import { MainSideBarComponent } from "./main-side-bar/main-side-bar.component";
import { NavBarComponent } from "./nav-bar/nav-bar.component";
import { ControlSideBarComponent } from "./control-side-bar/control-side-bar.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { SpinnerService } from "./shared/spinner-service";
import { AlertModule } from "./alerts";
import { RouterModule, Routes } from "@angular/router";
import { MDBBootstrapModule } from "angular-bootstrap-md";

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    FooterComponent,
    MainSideBarComponent,
    NavBarComponent,
    ControlSideBarComponent,
  ],
  imports: [
    MDBBootstrapModule.forRoot(),
    BrowserModule.withServerTransition({ appId: "serverApp" }),
    NgbModule,
    AlertModule,
    RouterModule.forRoot([], {
      initialNavigation: "enabled",
    }),
  ],
  providers: [SocketService, SpinnerService],
  bootstrap: [AppComponent],
})
export class AppModule {}
