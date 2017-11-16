import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { UserService } from '../user/user.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AdminGuard implements CanActivate {
  constructor(private router: Router, private userService: UserService) {}
  
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
      this.userService.setRecentRoute(state.url);
      console.log(this.userService.currentUser);
      if (this.userService.currentUser && JSON.stringify(this.userService.currentUser.authorities).search("ROLE_ADMIN") !== -1) {
        return true;
      } else {
        console.log("NOT AN ADMIN ROLE");
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
        return false;
      }
    }
  }