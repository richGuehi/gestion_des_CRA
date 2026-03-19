import { Component, inject, signal } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { SideBar } from './components/side-bar/side-bar';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SideBar],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  public router = inject(Router);
  protected readonly title = signal('cra-frontend');
}
