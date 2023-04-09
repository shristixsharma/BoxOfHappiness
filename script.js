//for hamburger menu
const bar= document.getElementById('bar');
const close= document.getElementById('close');
const nav =document.getElementById('navbar');
if(bar){
    bar.addEventListener('click', () =>{
        nav.classList.add('active');
    })
}
//for remove of hamburger menu cross sign
if(close){
    close.addEventListener('click', () =>{
    nav.classList.remove('active');
})
}