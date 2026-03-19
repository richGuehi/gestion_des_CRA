import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  standalone:true,
  imports: [CommonModule, RouterModule, MatListModule],  
  templateUrl: './side-bar.html',
  styleUrl: './side-bar.scss',
})
export class SideBar {

}
