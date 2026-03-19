import { CommonModule } from '@angular/common';
import { Component, inject, OnInit, signal } from '@angular/core';
import { UserService } from '../../services/user-service';
import { User } from '../user/user';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
})
export class Dashboard implements OnInit {
  private userService = inject(UserService)

  totalCollaborateurs = signal<number>(0);
  actifsCount =signal<number>(0);


  ngOnInit(): void {
    this.loadStats();
  }

  loadStats(){
    this.userService.getAllUsers().subscribe({
      next: (users) => {
        this.totalCollaborateurs.set(users.length);
        
        this.actifsCount.set(users.filter( u => u.active).length);
      },

      error: (err) => console.error('Erreur lors du chargement des stats', err)
    })
  }




}
