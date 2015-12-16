package a;


class HighestPrice extends MiddleSolution {
	Node[] nodeArr;
	double price;
	double addPercent;

	@Override
	public void input() {
		int eleCount = scanner.nextInt();
		price = scanner.nextDouble();
		addPercent = scanner.nextDouble() / 100 + 1;
		nodeArr = new Node[eleCount];
		for (int i = 0; i < eleCount; i++) {
			int parentId = scanner.nextInt();
			nodeArr[i] = new Node(i, parentId);
			if (parentId == -1) {
				nodeArr[i].level = 0;
			}
		}
	}

	@Override
	public void deal() {
		int maxLevel = 0;
		int maxCount = 1;
		for (Node node : nodeArr) {
			int level = node.getLevel();
			if (level > maxLevel) {
				maxLevel = level;
				maxCount = 1;
			} else if (level == maxLevel) {
				maxCount++;
			}
		}
		double maxPrice = price * Math.pow(addPercent, maxLevel);
		System.out.printf("%.2f %d", maxPrice, maxCount);

	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

	}

	class Node {
		Integer level;
		int parent;
		int id;

		public Node(int id, int parent) {
			this.parent = parent;
			this.id = id;
		}

		public Integer getLevel() {
			if (level == null) {
				level = nodeArr[parent].getLevel() + 1;
			}
			return level;
		}
	}

}
