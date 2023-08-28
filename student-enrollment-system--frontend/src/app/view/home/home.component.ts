import {Component, ViewChild} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {MatDrawer, MatSidenavModule} from "@angular/material/sidenav";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {FormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {Student} from "../../dto/Student";
import {GetAllStudentsService} from "../../service/get-all-students.service";
import {HttpClient} from "@angular/common/http";

class PeriodicElement {
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  standalone: true,
  imports: [NgIf, MatSidenavModule, MatCheckboxModule, FormsModule, MatButtonModule, NgForOf, MatTableModule, MatPaginatorModule]
})
export class HomeComponent {
  showFiller = false;
  public studentList:Array<Student>=[];
  private sameStudent:boolean = true;
  private previousStudent:any;
  displayedColumns: string[] = ['studentId', 'name', 'address', 'contact'];
  dataSource = new MatTableDataSource<Student>();

  constructor(public http: HttpClient,private getAllStudentsService:GetAllStudentsService) {
    this.getAllStudentsService.getStudents(http).subscribe(studentsList => {
      this.studentList = studentsList;
      this.dataSource.data = studentsList; // Update the dataSource with the received data
      console.log(this.studentList); // Log the data after it's received
    });
    console.log(this.studentList);
  }

  @ViewChild(MatPaginator) public paginator: MatPaginator=this.ngAfterViewInit();

  ngAfterViewInit() {
    return  this.dataSource.paginator = this.paginator;
  }

  sideNav(drawer: MatDrawer, row:Student) {
    if (this.sameStudent){
      drawer.toggle();
      this.sameStudent = false;
    }else if (row === this.previousStudent){
      drawer.toggle();
      this.sameStudent = true;
    }
    this.previousStudent = row;
    console.log(row);
  }
}
