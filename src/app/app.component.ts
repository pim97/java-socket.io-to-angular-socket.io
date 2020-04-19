import { Component, OnInit } from "@angular/core";
import { SocketService } from "./socket-service.service";
import { Event } from "./types";
import { Observable } from 'rxjs';
import { TableModel } from './tableModel';
import { SpinnerService } from '@shared/spinner-service';
import { AlertService } from './alerts';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {

  tableModel$: Observable<TableModel[]> = this.socketService.tableModel$;
  headElements = ['OrderId', 'Website', 'DidVoteThisSession', 'Success', 'ShouldHaveSuccess', 'UsedCaptchas'];

  ngOnInit(): void {
    this.socketService.connected();
    // this.socketService.chatEvent();
  }

  connected: boolean;

  constructor(
    public spinnerService: SpinnerService,
    private socketService: SocketService,
    private alertService: AlertService
    ) {}
    
}
