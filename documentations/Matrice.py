import os
import git

# Chemin vers votre dépôt Git
repo_path = r'C:\Users\Ayoub\Downloads\Kool-it'

# Assurez-vous que ce chemin est correct et pointe vers un dépôt Git valide
repo = git.Repo(repo_path)

# Remplacez par votre adresse email
your_email = 'votre.email@example.com'

contributor_stats = {}

for commit in repo.iter_commits():
    author = commit.author.email
    if author not in contributor_stats:
        contributor_stats[author] = {'commits': set(), 'lines_added': 0, 'lines_removed': 0, 'back_end': 0, 'front_end': 0, 'principal': 0}
    
    contributor_stats[author]['commits'].add(commit.hexsha)
    
    for item in commit.stats.files.items():
        filename, stats = item

        location = None
        if filename.startswith("Back_end"):
            location = 'back_end'
        elif filename.startswith("Front_end"):
            location = 'front_end'
        else:
            location = 'principal'
        
        contributor_stats[author][location] += stats['insertions'] - stats['deletions']
        contributor_stats[author]['lines_added'] += stats['insertions']
        contributor_stats[author]['lines_removed'] += stats['deletions']

# Calcul des contributions totales pour votre email
your_stats = contributor_stats.get(your_email, None)
if your_stats:
    total_contribution = sum(your_stats[location] for location in ['back_end', 'front_end', 'principal'])
    your_stats['total_contribution'] = total_contribution

# Chemin vers le répertoire de documentation
documentation_path = os.path.join(repo_path, 'documentations')
os.makedirs(documentation_path, exist_ok=True)  # Crée le répertoire s'il n'existe pas

# Chemin complet du fichier de sortie
output_file_path = os.path.join(documentation_path, "Matrice2_Python_output.txt")

# Écriture des résultats dans le fichier de sortie
with open(output_file_path, "w") as output_file:
    output_file.write("Contributeur | Commits | Lignes ajoutées | Lignes supprimées | Back-end | Front-end | Principal | Contribution Totale\n")
    for contributor, stats in contributor_stats.items():
        total_contribution = stats.get('total_contribution', 'N/A')
        output_file.write(f"{contributor} | {len(stats['commits'])} | {stats['lines_added']} | {stats['lines_removed']} | {stats['back_end']} | {stats['front_end']} | {stats['principal']} | {total_contribution}\n")
