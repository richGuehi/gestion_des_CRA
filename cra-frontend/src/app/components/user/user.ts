import { CommonModule } from '@angular/common';
import { Component, inject, OnInit, signal } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { UserService } from '../../services/user-service';
import { UserModel } from '../../models/user.models';

@Component({
  selector: 'app-user',
  standalone : true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './user.html',
  styleUrl: './user.scss',
})
export class User implements OnInit {

  private userService = inject(UserService)

  // pour les infos sur user qui arrivent du back
  users = signal<UserModel[]>([]);

  // les colones du tableau d'affichage 

  displayedColumns: string[] = ['nom', 'prenom', 'email', 'role', 'statut', 'seriorite', 'salaire', 'active', 'actions'];

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(){
    this.userService.getAllUsers().subscribe({
      next: (data) => {
        this.users.set(data);
        console.log('les users : ', this.users())
      },
      error: (err) => {
        console.error('Erreur lors de la recuperation des users', err);
      }
    })
  }


  editCollaborateur(collaborateur: any) {
    console.log('Bouton Editer cliqué pour :', collaborateur);
  }

  deleteCollaborateur(id: number) {
    console.log('Bouton Supprimer cliqué pour l\'ID :', id);
  }

  toggleActivation(id: number) {
    console.log('Bouton Activer/Désactiver cliqué pour l\'ID :', id);
  }
}
