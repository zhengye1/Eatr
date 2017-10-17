import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { UserService } from '../user/user.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AdminGuard implements CanActivate {
  constructor(private router: Router, private userService: UserService) {}
  
    canActivate(): boolean {
      console.log("Line 11: " + this.userService.currentUser);
      if (this.userService.currentUser) {
        return true;
      } else {
        this.router.navigate(['/login']);
        return false;
      }
    }
  }