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
    console.log("Submitting login form");
    if (!this.username || !this.password) {
      console.log("Username or password is empty");
      this.loginError = 'Please enter username and password';
      return;
    }
    this.loginService();

    this.isLoading = true;
    this.loginError = '';


  }
  loginService() {
    console.log("Login service called");
    this.adminService.verifyAdmin(this.username, this.password).subscribe({
      next: (verified: boolean) => {
        console.log("Login response received:", verified);
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
