import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminService} from '../../backend/admin-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css',
})
export class LoginPage {
  username: string = '';
  password: string = '';
  isLoading: boolean = false;
  loginError: string = '';
  isLoggedIn: boolean = false;

  constructor(
    private adminService: AdminService,
    private router: Router
  ) {}

  onSubmit() {
    if (!this.username || !this.password) {
      this.loginError = 'Please enter username and password';
      return;
    }

    this.isLoading = true;
    this.loginError = '';

    this.adminService.verifyAdmin(this.username, this.password).subscribe({
      next: (verified: boolean) => {
        this.isLoading = false;
        if (verified) {
          this.isLoggedIn = true;
          this.loginError = '';
          this.router.navigate(['/dashboard']);
        } else {
          this.loginError = 'Invalid credentials';
        }
      },
      error: (error: any) => {
        this.isLoading = false;
        this.loginError = 'Login failed. Please try again.';
        console.error('Login error:', error);
      }
    });
  }
}
