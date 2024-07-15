<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Character Showcase</title>
    <style>
        
        body {
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding-top: 300px;
           
        }
        .container {
            width: 250px;
            height: 300px;
            position: relative;
            perspective: 1100px;
        }
        #carousel {
            width: 100%;
            height: 100%;
            position: absolute;
            transform-style: preserve-3d;
            transition: transform 1s;
        }
        figure {
            width: 200px;
            height: 240px;
            margin: 0;
            padding: 5px 20px 0;
            box-sizing: border-box;
            position: absolute;
            cursor: pointer;
            filter: drop-shadow(0 0 20px rgb(0 0 0 / 50%));
            background-color: #333;
            border: 2px solid #fff;
            transition: transform 0.5s, filter 0.5s;
        }
        img {
            width: 100%;
            height: 100%;
            object-fit: contain;
            filter: contrast(1) brightness(1);
            transition: transform 0.5s, filter 0.5s;
        }
        .blurred img {
            filter: blur(10px);
        }
        figure.active img {
            transform: scale(2.2) translate(-10%, -10%);
            filter: contrast(1.5);
        }
        @keyframes rotating {
            from {
                transform: rotateY(0deg);
            }
            to {
                transform: rotateY(-360deg);
            }
        }
        #carousel div {
            position: absolute;
            width: 100px;
            height: 100px;
        }
        #carousel div:nth-child(1) { transform: rotateY(0deg) translateZ(400px); }
        #carousel div:nth-child(2) { transform: rotateY(45deg) translateZ(400px); }
        #carousel div:nth-child(3) { transform: rotateY(90deg) translateZ(400px); }
        #carousel div:nth-child(4) { transform: rotateY(135deg) translateZ(400px); }
        #carousel div:nth-child(5) { transform: rotateY(180deg) translateZ(400px); }
        #carousel div:nth-child(6) { transform: rotateY(225deg) translateZ(400px); }
        #carousel div:nth-child(7) { transform: rotateY(270deg) translateZ(400px); }
        #carousel div:nth-child(8) { transform: rotateY(315deg) translateZ(400px); }
    </style>
</head>
<body>
    <div class="container">
        <div id="carousel">
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240218/original/pngtree-dropshipping-men-hole-sole-jogging-shoes-png-image_14339669.png" alt="Necromancer">
                </figure>
            </div>
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240603/original/pngtree-branded-blue-wrist-watch-png-image_15240339.png" alt="Druid">
                </figure>
            </div>
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240218/original/pngtree-dropshipping-men-hole-sole-jogging-shoes-png-image_14339669.png" alt="Necromancer">
                </figure>
            </div>
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240603/original/pngtree-branded-blue-wrist-watch-png-image_15240339.png" alt="Druid">
                </figure>
            </div>
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240218/original/pngtree-dropshipping-men-hole-sole-jogging-shoes-png-image_14339669.png" alt="Necromancer">
                </figure>
            </div>
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240603/original/pngtree-branded-blue-wrist-watch-png-image_15240339.png" alt="Druid">
                </figure>
            </div>
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240218/original/pngtree-dropshipping-men-hole-sole-jogging-shoes-png-image_14339669.png" alt="Necromancer">
                </figure>
            </div>
            <div>
                <figure>
                    <img src="https://png.pngtree.com/png-clipart/20240603/original/pngtree-branded-blue-wrist-watch-png-image_15240339.png" alt="Druid">
                </figure>
            </div>
            
        </div>
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const carousel = document.getElementById('carousel');
            const figures = carousel.querySelectorAll('figure');
            let currentIndex = 0;
            let rotating = true;
            let rotationInterval;

            function updateCarousel() {
                if (rotating) {
                    figures.forEach((figure, index) => {
                        figure.classList.remove('active', 'blurred');
                        if (index === currentIndex) {
                            figure.classList.add('active');
                        } else {
                            figure.classList.add('blurred');
                        }
                    });

                    const degree = -currentIndex * 45;
                    carousel.style.transform = `rotateY(${degree}deg)`;

                    currentIndex = (currentIndex + 1) % figures.length;

                    rotating = false;
                    setTimeout(() => {
                        rotating = true;
                    }, 3000);
                }
            }

            rotationInterval = setInterval(updateCarousel, 3000);

            updateCarousel();
        });
    </script>
</body>
</html>
