import { Injectable } from "@angular/core";
import { Observable, Subject, BehaviorSubject } from "rxjs";
import { Observer } from "rxjs";
import { Event } from "./types";

import * as io from "socket.io-client";
import { TableModel } from "./tableModel";
import { SpinnerService } from "@shared/spinner-service";
import { AlertService } from "./alerts";

@Injectable()
export class SocketService {
  private socket;

  // Subjects
  private _tableModel$ = new BehaviorSubject<TableModel[]>(undefined);

  // Obseravbles
  tableModel$ = this._tableModel$.asObservable();

  constructor(
    private spinnerService: SpinnerService,
    private alertService: AlertService
  ) {
    this.socket = io.connect("http://localhost:3030", {
      withCredentials: false,
    });
  }

  options = {
    autoClose: true,
    keepAfterRouteChange: false,
  };

  connected() {
    this.socket.on("connect_error", (event: any) => {
      this._tableModel$.next([]);
      this.alertService.error(
        `Error: could not connect to WS errormsg: ${event}`,
        this.options
      );
      this.spinnerService.loading = true;
    });

    this.socket.on("connect", (event: any) => {
      console.log("connected", event);

      this.socket.on("tableModel", (data) => {
        const tableModels = JSON.parse(data);

        this._tableModel$.next(tableModels);
        console.log("tableModelValue", this._tableModel$.value);
        this.spinnerService.loading = false;
      });

      this.alertService.success(
        "Successfully connected to Websocket server",
        this.options
      );
    });
  }

  chatEvent() {
  }
}
