import { Component } from '@angular/core';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';
import {NgIf} from '@angular/common';
@Component({
  selector: 'app-students-table',
  templateUrl: './students-table.component.html',
  styleUrls: ['./students-table.component.scss'],
  standalone: true,
  imports: [MatSidenavModule, NgIf, MatButtonModule]
})
export class StudentsTableComponent {
  showFiller = false;
}

