window.addEventListener('scroll', function() {
    const header = document.querySelector('.header');
    const divider = document.querySelector('.divider');
    if (window.scrollY > 50) {
        header.classList.add('header-shrink');
        divider.classList.add('divider-shrink');
    } else {
        header.classList.remove('header-shrink');
        divider.classList.remove('divider-shrink');
    }
});