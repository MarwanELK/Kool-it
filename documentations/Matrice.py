import os
import git


repo_path = r'C:\Users\Ayoub\Downloads\Kool-it'

repo = git.Repo(repo_path)


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


for contributor, stats in contributor_stats.items():
    total_contribution = sum(stats[location] for location in ['back_end', 'front_end', 'principal'])
    stats['total_contribution'] = total_contribution

with open("Matrice2_Python_output.txt", "w") as output_file:
    output_file.write("Contributeur | Commits | Lignes ajoutées | Lignes supprimées | Back-end | Front-end | Principal | Contribution Totale\n")
    for contributor, stats in contributor_stats.items():
        total_contribution = stats['total_contribution']
        output_file.write(f"{contributor} | {len(stats['commits'])} | {stats['lines_added']} | {stats['lines_removed']} | {stats['back_end']} | {stats['front_end']} | {stats['principal']} | {total_contribution}\n")

