import { Component, AfterViewInit } from '@angular/core';

import jQuery from 'jquery'

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements AfterViewInit {
//  title = 'carwork-app';

constructor() {}

  ngAfterViewInit(){
    (function($) {
        "use strict";
    
        // Add active state to sidbar nav links
        var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
            $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
                if (this.href === path) {
                    $(this).addClass("active");
                }
            });
    
    })(jQuery);
  }
}



