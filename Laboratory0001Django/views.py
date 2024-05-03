from django.shortcuts import render


def index(request):
    vista = 'index.html'
    return render(request, vista)