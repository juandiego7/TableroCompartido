//*particlesJS es un archivo javascript escargado de gestionar la animación de 
//partículas que se encuentra en la parte superior de la salida en pantalla.*//
particlesJS( 
            {"particles": {"number": {"value": 200, "density": {"enable": true, "value_area": 1000}}, 
                    "color": {"value": "#7be800"}, 
                    "shape": {"type": "triangle", 
                    "stroke": {"width": 0, "color": "#000000"},
                    "polygon": {"nb_sides": 8.9},
                    "image": {"src": "img/github.svg", "width": 0, "height": 0}}, 
                    "opacity": {"value": 0.5, "random": false, 
                    "anim": {"enable": false, "speed": 1, "opacity_min": 0.1, "sync": false}}, 
                    "size": {"value": 3, "random": true, 
                    "anim": {"enable": false, "speed": 40, "size_min": 0.1, "sync": false}}, 
                    "line_linked": {"enable": true, "distance": 150, "color": "#000000", "opacity": 0.4, "width": 1},
                    "move": {"enable": true, "speed": 6, "direction": "none", "random": false, "straight": false, "out_mode": "out", "bounce": false, 
                    "attract": {"enable": false, "rotateX": 600, "rotateY": 1200}}}, 
                    "interactivity": {"detect_on": "canvas",
                    "events": {"onhover": {"enable": true, "mode": "grab"}, 
                    "onclick": {"enable": true, "mode": "push"}, "resize": true},
                    "modes": {"grab": {"distance": 400, 
                    "line_linked": {"opacity": 1}}, 
                    "bubble": {"distance": 400, "size": 40, "duration": 2, "opacity": 8, "speed": 3},
                    "repulse": {"distance": 200, "duration": 0.4}, 
                    "push": {"particles_nb": 4},
                    "remove": {"particles_nb": 2}}}, "retina_detect": true});   